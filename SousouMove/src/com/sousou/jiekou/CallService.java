package com.sousou.jiekou;

import com.sousou.soso1.MobileCard;

/**
 * 通话--接口
 */
public interface CallService {
	
    public abstract int call (int minCount, MobileCard card) throws Exception;
    
}
