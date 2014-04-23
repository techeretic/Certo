package com.pshetye.certo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class ProductsFragment extends Fragment {
	
	private ArrayList<String> ProductsList = new ArrayList<>(Arrays.asList(
			"Product 1", "Product 2", "Product 3", "Product 4"
			));	
	
	private ArrayList<String> ProductsDescript_1 = new ArrayList<>(Arrays.asList(
			"Brief Product 1 Description Line 1", 
			"Brief Product 1 Description Line 2", 
			"Brief Product 1 Description Line 3", 
			"Brief Product 1 Description Line 4", 
			"Brief Product 1 Description Line 5", 
			"       ..... MORE INFO .....      "
			));
	
	private ArrayList<String> ProductsDescript_2 = new ArrayList<>(Arrays.asList(
			"Brief Product 2 Description Line 1", 
			"Brief Product 2 Description Line 2", 
			"Brief Product 2 Description Line 3", 
			"Brief Product 2 Description Line 4", 
			"Brief Product 2 Description Line 5", 
			"       ..... MORE INFO .....      "
			));
	
	private ArrayList<String> ProductsDescript_3 = new ArrayList<>(Arrays.asList(
			"Brief Product 3 Description Line 1", 
			"Brief Product 3 Description Line 2", 
			"Brief Product 3 Description Line 3", 
			"Brief Product 3 Description Line 4", 
			"Brief Product 3 Description Line 5", 
			"       ..... MORE INFO .....      "
			));
	
	private ArrayList<String> ProductsDescript_4 = new ArrayList<>(Arrays.asList(
			"Brief Product 4 Description Line 1", 
			"Brief Product 4 Description Line 2", 
			"Brief Product 4 Description Line 3", 
			"Brief Product 4 Description Line 4", 
			"Brief Product 4 Description Line 5", 
			"       ..... MORE INFO .....      "
			));
	
	ProductListAdapter prlistAdapter;
	ExpandableListView expListView;
	HashMap<String, List<String>> listDataChild;
	
	OnActivityAttachedCallBacks mCallBack;
	
	// Container Activity must implement this interface
    public interface OnActivityAttachedCallBacks {
        public void UpdateActionBar(int position);
    }
	
	public ProductsFragment() {		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.product_list, container, false);
		
		listDataChild = new HashMap<String, List<String>>();
		
		listDataChild.put(ProductsList.get(0), ProductsDescript_1);
		listDataChild.put(ProductsList.get(1), ProductsDescript_2);
		listDataChild.put(ProductsList.get(2), ProductsDescript_3);
		listDataChild.put(ProductsList.get(3), ProductsDescript_4);
		
        return rootView;
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		try {
			mCallBack = (OnActivityAttachedCallBacks) activity;
		} catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnTwitterUserSelectedListener");
        }
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		// get the list view
        expListView = (ExpandableListView) getActivity().findViewById(R.id.product_list);
        
        prlistAdapter = new ProductListAdapter(getActivity(), ProductsList, listDataChild);
        
        expListView.setAdapter(prlistAdapter);
        
        expListView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				Toast.makeText(
                        getActivity(),
                        ProductsList.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                		ProductsList.get(groupPosition)).get(
                                        childPosition), Toast.LENGTH_SHORT)
                        .show();
				return false;
			}
		});
	}
}
