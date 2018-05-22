package com.sjh.action;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import oracle.net.aso.a;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.Block;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.BlockChainInfo;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.RawTransaction;

import com.sjh.entity.Account;
import com.sjh.entity.Blockinfo;
import com.sjh.entity.RencentBlock;
import com.sjh.entity.Transaction;
import com.sjh.service.imp.BcServiceImp;
import com.sjh.util.DateTime;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/bcc")
public class BcController2 {

	@Resource
	BcServiceImp bcserviceImp;

	@RequestMapping("/getblockinfo")//创世块201
	public String getblockinfo(Model model) throws MalformedURLException {
		BitcoindRpcClient rpcClient = new BitcoinJSONRPCClient(
				"http://RPCuser:RPCpasswd@localhost:8332");
		BlockChainInfo info = rpcClient.getBlockChainInfo();
	
		Blockinfo blockinfo = new Blockinfo();
		blockinfo.setBestBlockHash(info.bestBlockHash());
		blockinfo.setHeight(info.blocks());
		blockinfo.setChain(info.chain());
		blockinfo.setChainwork(info.chainWork());
		blockinfo.setDifficulty(info.difficulty());
		blockinfo.setHashcode(info.hashCode());
		blockinfo.setToString(info.toString());
		model.addAttribute("blockinfo", blockinfo);
		return "block/getinfo";
	}

	@RequestMapping("/listaccounts")//列出所有的账户401
	public String listaccounts(Model model) throws MalformedURLException {
		BitcoindRpcClient rpcClient = new BitcoinJSONRPCClient(
				"http://RPCuser:RPCpasswd@localhost:8332");
		List<Account> list = new ArrayList<>();
		Map<String, Number> accountsMap = rpcClient.listAccounts();
		for (Map.Entry<String, Number> account : accountsMap.entrySet()) {
			System.out.println("Key = " + account.getKey() + ", Value = "
					+ account.getValue());
			Account a = new Account();
			a.setName(account.getKey());
			a.setNumber(account.getValue());
			a.setAddress(rpcClient.getAddressesByAccount(account.getKey()).get(
					0));

			list.add(a);
		}
		list.get(0).setName("host_sjh");
		list.get(1).setName("tom");
		model.addAttribute("list", list);
		return "block/listaccounts";
	}

	@RequestMapping("/addaccount")//增加账户（输入昵称得到地址）同401
	public String addaccount(Model model, String accountname)
			throws MalformedURLException {
		BitcoindRpcClient rpcClient = new BitcoinJSONRPCClient(
				"http://RPCuser:RPCpasswd@localhost:8332");
		rpcClient.getNewAddress(accountname);
		List<Account> list = new ArrayList<>();
		Map<String, Number> accountsMap = rpcClient.listAccounts();
		for (Map.Entry<String, Number> account : accountsMap.entrySet()) {
			System.out.println("Key = " + account.getKey() + ", Value = "
					+ account.getValue());
			Account a = new Account();
			a.setName(account.getKey());
			a.setNumber(account.getValue());
			a.setAddress(rpcClient.getAddressesByAccount(account.getKey()).get(
					0));

			list.add(a);
		}
		list.get(0).setName("host_sjh");
        list.get(1).setName("tom");
		model.addAttribute("list", list);
		return "block/listaccounts";
	}

	
	@RequestMapping("/gosendtoaddress")//只是为了从mian页面转到新的转账页面（501的中介）
	public String gosendtoaddress(Model model) throws MalformedURLException {

		return "block/sendmoney";
	}

	@RequestMapping("/sendtoaddress")//完成转账 501
	public String sendtoaddress(Model model, String address, String coin)
			throws MalformedURLException {
		BitcoindRpcClient rpcClient = new BitcoinJSONRPCClient(
				"http://RPCuser:RPCpasswd@localhost:8332");
		String txhash = rpcClient.sendToAddress(address,
				Double.parseDouble(coin));
		rpcClient.listTransactions();
		model.addAttribute("txhash", txhash);
		return "block/txhash";
	}
	@RequestMapping("/blockchianinfo1")//得到最近的八个区块信息601
	public String blockchianinfo(Model model) throws MalformedURLException {
		BitcoindRpcClient rpcClient = new BitcoinJSONRPCClient(
				"http://RPCuser:RPCpasswd@localhost:8332");
		List<RencentBlock> list = new ArrayList<>();

		int height = rpcClient.getBlockCount();
		for (int i = height; i >= height - 7; i--) {
			String hashs = rpcClient.getBlockHash(i);
			Block content = rpcClient.getBlock(hashs);
			Date tim = content.time();
			int size = content.size();
			List<String> tx = content.tx();
			RencentBlock recentBlock = new RencentBlock();
			recentBlock.setHeight(i);
			recentBlock.setBlockHash(hashs);
			recentBlock.setSize(size);
			recentBlock.setTim(tim);
			recentBlock.setTx(tx);
			list.add(recentBlock);
		}
		model.addAttribute("list", list);

		return "block/recentblocks";

	}

	@RequestMapping("/getblockbyhash")//点击区块哈希得到详细区块信息 601.1
	public String getblockbyhash(Model model,String hashs,String tr)
			throws MalformedURLException {
		BitcoindRpcClient rpcClient = new BitcoinJSONRPCClient(
				"http://RPCuser:RPCpasswd@localhost:8332");
		Blockinfo block =new Blockinfo();
		Block b=rpcClient.getBlock(hashs);
		block.setHashcode(b.hashCode());
		block.setHash(b.hash());
		block.setBits(b.bits());
		block.setTx(b.tx());
		block.setDifficulty(b.difficulty());
		block.setHeight(b.height());
		block.setTimeDate(b.time());
		block.setMerkleroot(b.merkleRoot());
		block.setNonce(b.nonce());
		block.setVersion(b.version());
		block.setSize(b.size());
		block.setNext(b.nextHash());
		block.setPrevious(b.previousHash());
		
		model.addAttribute("block",block);
		return "block/blockbyhash";
	}
	
	@RequestMapping("/gettransactionbytid")//点击交易哈希得到交易输入输出详情 601.1.1
	public String gettransactionbytid(Model model,String tid,int txindex)
			throws MalformedURLException {
		BitcoindRpcClient rpcClient = new BitcoinJSONRPCClient(
				"http://RPCuser:RPCpasswd@localhost:8332");
		RawTransaction rawString;
		rawString = rpcClient.getRawTransaction(tid);
		String rawhex=rpcClient.getRawTransactionHex(tid);
		Transaction transaction1= new Transaction();
		transaction1.setTxid(rawString.txId());
		transaction1.setHashcode(rawString.blockHash());
		transaction1.setVin(rawString.vIn());
		transaction1.setVout(rawString.vOut());
		transaction1.setrawhex(rawhex);
		model.addAttribute("transaction",transaction1);
		model.addAttribute("txindex",txindex);
		return "block/transactionbytid";
	}
	
}
