package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jeffrey on 11/15/2015.
 */
public class BeverageData {//  A Singleton to hold the Beverage Data
    private static BeverageData sBeverageData;

    private List<Beverage> mBeverages;

    Context mContext;

    public static BeverageData get(Context context){
        if (sBeverageData == null) {
            sBeverageData = new BeverageData(context);
        }
        return sBeverageData;
    }

    private BeverageData(Context context){
        mBeverages = new ArrayList<>();
        mContext = context;

        this.loadBeverageList();
    }

    public List<Beverage> getBeverages(){
        return mBeverages;
    }

    private void loadBeverageList() {
        Scanner scanner;

        try {
            scanner = new Scanner(mContext.getResources().openRawResource(R.raw.beverage_list));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String parts[] = line.split(",");

                int Id = Integer.parseInt(parts[0]);
                String Name = parts[1];
                String Pack = parts[2];
                double Price = Double.parseDouble(parts[3]);
                boolean Active =Boolean.parseBoolean(parts[4]);

                mBeverages.add(new Beverage(Id,Name,Pack,Price,Active));
            }
        }catch (Exception e){
            Log.e("Read CSV", e.toString());
        }
    }

}
