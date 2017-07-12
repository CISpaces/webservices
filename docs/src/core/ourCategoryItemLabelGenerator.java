/******************************************************************************
 * This research was sponsored by the U.S. Army Research Laboratory and the
 * U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
 * Project 6, Task 3: Collaborative Intelligence Analysis.
 * The U.S. and U.K. Governments are authorized to reproduce and distribute
 * reprints for Government purposes notwithstanding any copyright notation
 * hereon.
 * **************************************************************************
 * 
 * 
 * 
 * @author      Alice Toniolo  
 * @version     1.0  
 * @since 		April 2015           
 *   
 */

package core;

import java.util.ArrayList;

import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.data.category.CategoryDataset;

public class ourCategoryItemLabelGenerator implements CategoryItemLabelGenerator {
	private ArrayList labels;
	public ourCategoryItemLabelGenerator(ArrayList list){
		 labels=list;
	}
	
	
	@Override
	public String generateColumnLabel(CategoryDataset arg0, int arg1) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String generateLabel(CategoryDataset arg0, int arg1, int arg2) {
		// TODO Auto-generated method stu
		
		return (String) labels.get(arg1);
	}

	@Override
	public String generateRowLabel(CategoryDataset arg0, int arg1) {
		// TODO Auto-generated method stub
		return "";
	}

}
