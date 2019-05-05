package gui;

import constant.Images;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class StatusButton extends Button{
	
	public enum Status{
		MOVE, SUMMON, SUMMONGOD;
	}
	
	private Status status;
	
	public StatusButton(Status status) {
		setStatus(status);
		this.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void setStatus(Status status) {
		this.status = status;
		if(status == Status.MOVE)this.setGraphic(new ImageView(Images.moveButton));
		else if(status == Status.SUMMON) this.setGraphic(new ImageView(Images.summonButton));
	}
	
	public Status getStatus() {
		return status;
	}
	
	
}
