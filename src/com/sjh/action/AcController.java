package com.sjh.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.entity.Ac;
import com.sjh.service.imp.AcServiceImp;

@Controller
@RequestMapping("/ac")
public class AcController {

	@Resource
	AcServiceImp acServiceImp;

	@RequestMapping("/list")
	public String aclist(Model model) {
		List<Ac> list = acServiceImp.getAllacs();
		model.addAttribute("list", list);
		return "WEB-INF/ac/list";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Ac add(Ac ac) {
		acServiceImp.insert(ac);
		return ac;
	}

	@RequestMapping("/del")
	public String del(Model model, int id) {
		acServiceImp.deleteByPrimaryKey(id);
		List<Ac> list = acServiceImp.getAllacs();
		model.addAttribute("list", list);
		return "WEB-INF/ac/list";
	}

	@RequestMapping("/modify")
	@ResponseBody
	public Ac modify(Ac ac) {
		acServiceImp.updateByPrimaryKeySelective(ac);
		return ac;
	}

	@RequestMapping("/data")
	public String pictable() {
		return "WEB-INF/ac/datatable";
	}

	@RequestMapping("/addedit")
	public String addedit() {
		return "WEB-INF/addedit";
	}
}
