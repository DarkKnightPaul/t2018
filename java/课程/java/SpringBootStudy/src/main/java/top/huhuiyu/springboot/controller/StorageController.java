package top.huhuiyu.springboot.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springboot.dao.TbGoodsDAO;
import top.huhuiyu.springboot.entity.Storage;
import top.huhuiyu.springboot.util.JsonMessage;

@RestController
@RequestMapping("/storage")
public class StorageController {
	@Autowired
	private TbGoodsDAO tbGoodsDAO;

	@RequestMapping("/get")
	@ResponseBody
	public JsonMessage getData() throws Exception {
		JsonMessage message = JsonMessage.getSuccess("获取成功");
		message.putData("myid", UUID.randomUUID().toString());
		message.putData("goods", tbGoodsDAO.query().get(0));
		return message;
	}

	@RequestMapping("/send")
	@ResponseBody
	public JsonMessage sendData(Storage storage) {
		JsonMessage message = JsonMessage.getSuccess("发送成功");
		message.putData("myid", storage.getUuid());
		message.putData("goods", storage.getGoods());
		return message;
	}
}
