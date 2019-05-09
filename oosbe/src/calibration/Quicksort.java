package calibration;

import java.util.ArrayList;

public class Quicksort {
	private ArrayList<Integer> list;
	
	public Quicksort(ArrayList<Integer> plist) {
		 list = plist;
		 this.sort(0, list.size() - 1);
	}

    public void sort(int l, int r) {
        int q;
        if (l < r) {
            q = partition(l, r);
            sort(l, q);
            sort(q + 1, r);
        }
    }

    int partition(int l, int r) {

        int i, j, x = list.get((l + r) / 2);
        i = l - 1;
        j = r + 1;
        while (true) {
            do {
                i++;
            } while (list.get(i) < x);

            do {
                j--;
            } while (list.get(j) > x);

            if (i < j) {
                int k = list.get(i);
                list.set(i,list.get(j));
                list.set(j,k);
            } else {
                return j;
            }
        }
    }
    
    public ArrayList<Integer> getsortedList(){
    	return list;
    }
} 
