 package com.thetalkerapp.tests.fragmentwithinfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MiddleFragment extends Fragment {
	
	public static MiddleFragment newInstance() {
		MiddleFragment f = new MiddleFragment();
		return f;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.middle_layout, container, false);
	}
}
	
