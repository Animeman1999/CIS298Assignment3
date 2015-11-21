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

    private List<Beverage> mBeverages; //Variable to hold a list of Beverages.

    Context mContext;// To hold the Context passed into the Constructor.

    public static BeverageData get(Context context){ //Method to create the singelton.
        if (sBeverageData == null) {
            sBeverageData = new BeverageData(context);
        }
        return sBeverageData;
    }

    private BeverageData(Context context){ //Private method that creates the Beverage ArrayList.
        mBeverages = new ArrayList<>();
        mContext = context;

        this.loadBeverageList();//Call the method loadBeverageList to load the data from a file.
    }

    public List<Beverage> getBeverages(){// Method called to return the Beverage List.
        return mBeverages;
    }

    public Beverage getBeverage (int id){// Method called to return a single beverage based on it's id

        //Go through all the Beverages looking for a specific ID
        for (Beverage beverage: mBeverages){

            //Return the beverage if id is found.
            if (Integer.valueOf(beverage.getId()).equals(id)){
                return beverage;
            }
        }
        //No id was found so return null.
        return null;
    }


    private void loadBeverageList() {//Load the Lis of Beverage from a file.
        Scanner scanner;

        try {//Use try catch in case of errors while reading the file.

            // Create a new scanner tha opens up the file beverage_List in the directory raw.
            scanner = new Scanner(mContext.getResources().openRawResource(R.raw.beverage_list));

            while (scanner.hasNextLine()){ //  Loop while there is another line to be read

                String line = scanner.nextLine(); // Read in one line of the file

                String parts[] = line.split(","); //Split the line read into parts delineated by a comma.

                // TAKE THE SPLIT PARS FROM THE LINE READ IN, AND PLACE INTO THE VARIABLES CREATED FOR EACH DATA TYPE.
                int Id = Integer.parseInt(parts[0]);
                String Name = parts[1];
                String Pack = parts[2];
                double Price = Double.parseDouble(parts[3]);
                boolean Active =Boolean.parseBoolean(parts[4]);

                // Add to the beverage list (mBeverages), a new Beverage using the variables just created and loaded with the data read from the file.
                mBeverages.add(new Beverage(Id,Name,Pack,Price,Active));
            }
        }catch (Exception e){// Log any errors
            Log.e("Read CSV", e.toString());
        }
    }

}
