package com.pshetye.certo;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ProductBenefitFragments extends Fragment {

	ListView listview ;
	private  ArrayList<String> 	product_desc = new  ArrayList <>(Arrays.asList("Death benefits",
			"Maturity benefits", 
			"Periodic payment/Survival benefit", 
			"Surrender Value",
			"Surrender charges",
			"Lien"
			));

	public ProductBenefitFragments() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.product_benefit_fragment, container, false);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		listview = (ListView) getActivity().findViewById(R.id.list_product_benefit);
		MyListAdapter myListAdapter = new MyListAdapter(getActivity(), R.id.list_product_benefit, product_desc);
		listview.setAdapter(myListAdapter);

	}

	public class MyListAdapter extends ArrayAdapter<String> {

		ArrayList<String> temp ;  
		public MyListAdapter(Context context, int resource, ArrayList<String> objects) {
			super(context, resource, objects);
			// TODO Auto-generated constructor stub
			temp = objects;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;

			if (v == null) {
				LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.product_benefit_list_item, null);
			}

			if (temp != null) {             
				TextView title = (TextView) v.findViewById(R.id.header);
				TextView description = (TextView) v.findViewById(R.id.description);
				if (title != null) {
					title.setText(temp.get(position));
				}
				if (description != null) {
					description.setText("Text Description");
				}
				title = null;
				description = null;
			}

			return v;
		}

	}

}
