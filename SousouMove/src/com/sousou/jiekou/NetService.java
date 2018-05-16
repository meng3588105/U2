package com.sousou.jiekou;

import com.sousou.soso1.MobileCard;

/**
 *  上网流量---接口
 */
public interface NetService {
	
    public abstract int netPlay(int flow, MobileCard card) throws Exception;
    
}
