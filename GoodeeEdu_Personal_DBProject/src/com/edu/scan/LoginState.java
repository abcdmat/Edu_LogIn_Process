package com.edu.scan;

public interface LoginState {
	static final boolean STATE_DEFAULT = false;
	static final boolean STATE_LOGIN = true;
	
	static final int DO_LOGIN = 0;
	static final int DO_SIGNUP = 1;
	static final int DO_FIND_ID = 2;
	static final int DO_FIND_PW = 3;
}
