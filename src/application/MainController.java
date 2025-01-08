package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable{
	
	@FXML
	private ListView<String> lvDisease;
	
	@FXML
	private Button btnClear;
	
	@FXML
    private ListView<String> lvNumber;
	
	@FXML
    private Button btnClose;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Button btnOpen;
    
    @FXML
    private Label lblNumber;
    
    @FXML
    private Label lblTime;
    
    

    
    @FXML
    private Label lblText;

    @FXML
    private Label lblX;
    
    @FXML
    private Button btn;
    
    @FXML
    private CheckBox chkEat;

    
    Thread thread;
    MultiThreadDetect task;
    
    ScheduledExecutorService scheduler ;
    ScheduledFuture<?> future;
    ScheduledFuture<?> future2;
    ScheduledFuture<?> future3;
    boolean isFind;
    boolean isAction;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    @FXML
    void btnOpenClick(ActionEvent event) throws IOException {
    	if(chkEat.isSelected())
    	{
    		btnOpen.setDisable(true);
        	btnClose.setDisable(false);

        	lblNumber.setText("������...\n�Ф��^GTA�e��");
        	lblNumber.setAlignment(Pos.CENTER);
        	lblNumber.setOpacity(1);
        	lblTime.setOpacity(1);
        	lblText.setOpacity(1);
        	lblX.setOpacity(1);
        	
        	scheduler = Executors.newScheduledThreadPool(2);
        	

        	future = scheduler.scheduleAtFixedRate(new MultiThreadAction(1,this), 0, 1,TimeUnit.SECONDS);
        	future2 = scheduler.scheduleAtFixedRate(new MultiThreadAction(2,this), 0, 1,TimeUnit.SECONDS);
        	future3 = scheduler.scheduleAtFixedRate(new MultiThreadAction(3,this), 0, 1,TimeUnit.SECONDS);
        	
        
    	}
    	else
    	{
    		btnOpen.setDisable(true);
        	btnClose.setDisable(false);

        	lblNumber.setText("������...\n�Ф��^GTA�e��");
        	lblNumber.setAlignment(Pos.CENTER);
        	lblNumber.setOpacity(1);

        	lblX.setOpacity(1);
        	
        	scheduler = Executors.newScheduledThreadPool(1);

//        	future = scheduler.scheduleAtFixedRate(new MultiThreadAction(1,this), 0, 1,TimeUnit.SECONDS);
        	future2 = scheduler.scheduleAtFixedRate(new MultiThreadAction(2,this), 0, 1,TimeUnit.SECONDS);
        	future3 = scheduler.scheduleAtFixedRate(new MultiThreadAction(3,this), 0, 1,TimeUnit.SECONDS);
    	}
    	
    	chkEat.setDisable(true);
    }

    @FXML
    void btnCloseClick(ActionEvent event) {
    	if(chkEat.isSelected())
    	{
    		btnClose.setDisable(true);
//       	btnClose.setOpacity(0);
        	btnOpen.setDisable(false);

        	lblNumber.setOpacity(0);
        	lblTime.setOpacity(0);
        	lblText.setOpacity(0);
        	
        	future.cancel(true);
        	future2.cancel(true);
        	future3.cancel(true);
        	future = null;
        	future2 = null;
        	future3 = null;
    		scheduler.shutdown();
    		lblX.setText("x");
    		lblX.setOpacity(0);
    	}
    	else
    	{
    		btnClose.setDisable(true);

        	btnOpen.setDisable(false);

        	lblNumber.setOpacity(0);
        	lblTime.setOpacity(0);
        	lblText.setOpacity(0);
        	
//        	future.cancel(true);
        	future2.cancel(true);
        	future3.cancel(true);
        	future = null;
        	future2 = null;
        	future3 = null;
    		scheduler.shutdown();
    		lblX.setText("x");
    		lblX.setOpacity(0);
    	}
    	chkEat.setDisable(false);
    }
    @FXML
    void btnClick(ActionEvent event) {
    	System.out.println("future : isCancelled : "+future.isCancelled()+"  isDone : "+future.isDone());
    	System.out.println("future2 : isCancelled : "+future2.isCancelled()+"  isDone : "+future2.isDone());
    	System.out.println("future3 : isCancelled : "+future3.isCancelled()+"  isDone : "+future3.isDone());
    	
    }
    @FXML
    void btnClearClick(ActionEvent event) {
    	lvNumber.getItems().clear();
    	lvDisease.getItems().clear();
    }
    public void setLabelNumber(int number)
    {
    	System.out.println("���]�isetLabelNumber : "+number);
    	if(number >=0 && number <= 9)
    	{
    		isFind = true;
    		lblNumber.setText("�w���Ʀr : "+number+"\n�W����쪺�ɶ��� : "+dtf.format(LocalDateTime.now()));
    	}
    		
    	else
    	{
    		if(isFind)
    		{
    			return;
    		}
    		else
    			lblNumber.setText("������.....\n�Ф��^GTA�e��");
    	}
    		
    }
    public void addlvNumber(int number)
    {
    	if(number >=0 && number <= 9)
    	{
    		isFind = true;
    		lvNumber.getItems().add(dtf.format(LocalDateTime.now()) + " ���Ʀr : "+number);
    		
    	}
    }
    public void addlvDisease(String disease)
    {
    	//1 �z�G��
    	//2 �o�N
    	//3 ���H
    	//4 �P�_
    	System.out.println("���ͯf :"+disease);
    	
		lvDisease.getItems().add(dtf.format(LocalDateTime.now()) + " ���ͯf :"+disease);
			

    }
    public void setX(String x)
    {
    	lblX.setText(x);
    }
    public void setTime(String input)
    {
    	lblTime.setText(input);
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		try {
//			task = new MultiThreadDetect(this);
//			isAction = false;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(int i =0; i<50 ;i++)
//			lvNumber.getItems().add(""+i);
	}
    
    
}
