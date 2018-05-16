package com.sousou.jiekou;

import com.sousou.soso1.MobileCard;

	/**
	 * 短信---接口
	 */
	public interface SendService {
	    public abstract int send(int count, MobileCard card) throws Exception;
	}

