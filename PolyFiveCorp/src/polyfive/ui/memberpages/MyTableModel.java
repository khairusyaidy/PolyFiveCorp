//program name MyTableModel.java
//purpose //purpose create table and use table to call the DAO to set or get cells value
//name qing hui
//admin no 121997Q
//module group IS 1201
//last modified 4/2/2012

package polyfive.ui.memberpages;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import polyfive.entities.dao.Seat;

@SuppressWarnings("serial")
public class MyTableModel extends AbstractTableModel {
	
	private int rows;
	private int cols;
	private double price;
	private static MyTableModelCell[][] cells;
	
	//private static VariableSeat obj;
	//static ArrayList<VariableSeat>arrlist = new ArrayList<VariableSeat>();

	public MyTableModel(int rows, int cols) throws Exception{
		if (rows <= 0 || cols <= 0 && rows > 26 ) {
			throw new Exception("Invalid number of rows or columns");
		}
		
		this.rows = rows + 2;
		this.cols = cols + 2;
		
		cells = new MyTableModelCell[rows+2][cols+2];
		

		for (int i = 0; i < cells.length; ++i){
			for (int j = 0; j < cells[0].length; ++j){
				// assign each table cell with a seat
				cells[i][j] = new MyTableModelCell();
				cells[i][j].cellData = "";
		//		
			}
		}
		
		setScreenArea();
		setVerticalSeatIndices();
		setHorizontalSeatIndices();
		
	}
	public MyTableModel(ArrayList<Seat> seats) throws Exception{
		
		if (seats == null) {
			throw new Exception("seats cannot be null");
		}
		
		int _rows = -1, _cols = -1;
		for (int i = 0; i < seats.size(); ++i) {
			Seat seat = seats.get(i);
			if (seat.getRow() > _rows) {
				_rows = seat.getRow();
			}
			if (seat.getCol() > _cols) {
				_cols = seat.getCol();
			}
		}
		
		if (_rows <= 0 || _cols <= 0 && _rows > 26 ) {
			throw new Exception("Invalid number of rows or columns");
		}
		
		this.rows = _rows + 2;
		this.cols = _cols + 2;
		
		cells = new MyTableModelCell[rows+2][cols+2];
		
		for (int i = 0; i < cells.length; ++i){
			for (int j = 0; j < cells[0].length; ++j){
				// assign each table cell with a seat
				cells[i][j] = new MyTableModelCell();
				cells[i][j].cellData = "";
			}
		}
		
		for (int i = 0; i < seats.size(); ++i) {
			Seat seat = seats.get(i);
			cells[seat.getRow()][seat.getCol()].seat = seat;
			String str =Double.toString(seat.getPrice());
			cells[seat.getRow()][seat.getCol()].cellData =str;
			
			
		}
		
		setScreenArea();
		setVerticalSeatIndices();
		setHorizontalSeatIndices();
	}
	
	private boolean isCellAtBorder(int row, int col){
		return (row == 0 || row == this.rows - 1 || 
				col == 0 || col == this.cols - 1);
	}
	
	private void setScreenArea(){
		for (int i = 1; i < this.cols - 1; ++i){
			cells[0][i].cellData = "Screen";
			
		}
	}

	private void setVerticalSeatIndices(){
		for (int i = 1; i < this.rows - 1; ++i){                      //replace A with B achieved row is letter and column is numbers
			cells[i][0].cellData = cells[i][this.cols - 1].cellData =String.valueOf("row "+i);
			
		}
		
	}
	
	
	private void setHorizontalSeatIndices(){
		for (int i = 1; i < cells[this.rows - 1].length - 1; ++i){
			cells[this.rows - 1][i].cellData = String.valueOf("col "+i);
		
			                                 //replace B with A
		}
	}
	
//
	private void setSeatPlaces(){
		for (int i = 1; i < this.rows - 1; ++i){ 
				for(int j =  1; j < this.cols - 1; j++){//replace A with B achieved row is letter and column is numbers
					cells[i][j].cellData = cells[i][this.cols - 1].cellData = Character.toString((char)(0x40 + i)) + String.valueOf(j);
					
				
				}
		}
	}
	
	public boolean isColumnSelected(int cols,int row){
		if(!isCellAtBorder(row ,cols))
			return false;
		return true;
	}
	public boolean isRowSelected(int row,int cols){
		return !isCellAtBorder(row ,cols);	
	}

//
	@Override
	public int getColumnCount() {
		return this.cols;
	}

	@Override

	public int getRowCount() {
		return this.rows;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return cells[row][col].cellData;
	}

	@Override
	public boolean isCellEditable(int row, int col) {//set table to be editable
		return !isCellAtBorder(row, col);
	}
	public static int getLargerRow(int firstRow,int secondRow){
		int z = firstRow;
		if(z<secondRow){
			z=secondRow;
			return z;
		}
		
		return z;
	}
	public static int getSmallerRow(int firstRow,int secondRow){
		int z = firstRow;
		if(z>secondRow){
			z =secondRow;
		}
		
		return z;
	}
	public static int getLargerCol(int firstCol,int secondCol){
		int z = firstCol;
		if(z<secondCol){
			z=secondCol;
			return z;
		}
		
		return z;
	}
	public static int getSmallerCol(int firstCol,int secondCol){
		int z = firstCol;
		if(z>secondCol){
			z =secondCol;
		}
		
		return z;
	}
	
	
	public void setPricing(int firstRow,int firstCol,int secondRow,int secondCol,double seatPrice,int available, int id){
				int firstRows= getSmallerRow(firstRow,secondRow);
				int secondRows= getLargerRow(firstRow,secondRow);
				int firstCols = getSmallerCol(firstCol,secondCol);
				int secondCols = getLargerCol(firstCol,secondCol);
				for(int i = firstRows; i<secondRows+1;i++){
					for(int j = firstCols; j<secondCols+1;j++){
						cells[i][j].seat.setRow(i);
						cells[i][j].seat.setCol(j);
						cells[i][j].seat.setStatus(available);
						cells[i][j].seat.setPrice(seatPrice);
						cells[i][j].seat.setEventId(id);
						cells[i][j].cellData = Double.toString(seatPrice);
						cells[i][j].seat.save();
						
					}
				}
	}
}

