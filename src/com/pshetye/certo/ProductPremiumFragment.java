package com.pshetye.certo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ProductPremiumFragment extends Fragment{

	public ProductPremiumFragment() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootv = inflater.inflate(R.layout.product_premium_fragment, container, false);
		return rootv;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Spinner sp_occupation = (Spinner)getActivity().findViewById(R.id.sp_occupation);
		Spinner sp_age = (Spinner)getActivity().findViewById(R.id.sp_age);
		Spinner sp_sum = (Spinner)getActivity().findViewById(R.id.sp_sum);
		String[] occupations = new String[]{"Software", "Engineering", "Banking/Finance", "Government", "Business"};
		String[] ages = new String[]{"18", "19", "20", "21"};
		String[] sums = new String[]{"18,000", "19,000", "20,000", "21,000"};
		ArrayAdapter<String> occ_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, occupations);
		ArrayAdapter<String> ages_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ages);
		ArrayAdapter<String> sums_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, sums);
		
		sp_occupation.setAdapter(occ_adapter);
		sp_age.setAdapter(ages_adapter);
		sp_sum.setAdapter(sums_adapter);
	}
}
