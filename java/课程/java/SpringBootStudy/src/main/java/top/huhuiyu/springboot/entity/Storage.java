package top.huhuiyu.springboot.entity;

import java.io.Serializable;

public class Storage implements Serializable {

	private static final long serialVersionUID = 9130391358027547371L;

	private String uuid;
	private TbGoods goods;

	public Storage() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public TbGoods getGoods() {
		return goods;
	}

	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Storage [uuid=" + uuid + ", goods=" + goods + "]";
	}

}
