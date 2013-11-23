package com.thetalkerapp.tests.fragmentwithinfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {

	SingleTestQuestionView leftFragment;
	MiddleFragment middleFragment;
	
	private MyAdapter mPagerAdapter;
	private ViewPager mPager;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		final LayoutInflater inflater = LayoutInflater.from(this);
		final View view = inflater.inflate(R.layout.activity_main, null);
		
		setContentView(view);
		
		mPagerAdapter = new MyAdapter(getSupportFragmentManager());
		mPager = (ViewPager)findViewById(R.id.pager_large);
		mPager.setAdapter(mPagerAdapter);
		
	}

	public class MyAdapter extends FragmentStatePagerAdapter {

		private Fragment currFragment;

		public MyAdapter(FragmentManager fm) {
			super(fm);
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			super.destroyItem(container, position, object);
		}
		
		@Override
		public int getItemPosition(Object object) {
			return PagerAdapter.POSITION_NONE;
		}

		@Override
		public int getCount() {
			return 2;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position){
			case 0:
				if (leftFragment == null) {
					TestPaperQuestion q = new TestPaperQuestion();
					leftFragment = SingleTestQuestionView.newInstance(q);
				}
				return leftFragment;
			case 1:
				if (middleFragment == null) {
					middleFragment = MiddleFragment.newInstance();
				}
				return middleFragment;
			}
			return null;
		}

		/**
		 * Overriding this method to deal with recreation on orientation change. See: http://stackoverflow.com/a/17629575/362298
		 */
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			switch(position) {
				case 0:
					SingleTestQuestionView left = (SingleTestQuestionView)super.instantiateItem(container, position);
					return left;
				case 1:
					MiddleFragment middle = (MiddleFragment)super.instantiateItem(container, position);
					return middle;
			}
			return null;
		}
		
		public Fragment getCurrentItem() {
			return currFragment;
		}

		@Override
		public void setPrimaryItem(ViewGroup container, int position,
				Object object) {
			super.setPrimaryItem(container, position, object);
			currFragment = (Fragment)object;
		}
	}
}
