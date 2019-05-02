package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class SettingBox extends HBox {
	private Button leftButton, rightButton;
	private List<Label> Labels;
	private int currentLabel;
	public SettingBox(String text1, String text2, String text3) {
		this.setMinWidth(450);
		Label label1 = createLabel(text1);
		Label label2 = createLabel(text2);
		Label label3 = createLabel(text3);
		Labels = new ArrayList<Label>();
		Labels.add(label1);
		Labels.add(label2);
		Labels.add(label3);
		this.currentLabel = 0;
		setLeftRightButton();
		this.getChildren().addAll(leftButton, label1, rightButton);
	}
	public SettingBox(String text1, String text2, String text3, String text4) {
		this.setMinWidth(450);
		Label label1 = createLabel(text1);
		Label label2 = createLabel(text2); 
		Label label3 = createLabel(text3);
		Label label4 = createLabel(text4);
		Labels = new ArrayList<Label>();
		Labels.add(label1);
		Labels.add(label2);
		Labels.add(label3);
		Labels.add(label4);
		this.currentLabel = 0;
		setLeftRightButton();
		this.getChildren().addAll(leftButton, label1, rightButton);
	}
	private void setLeftRightButton() {
		leftButton = new Button();
		leftButton.setPrefSize(30, 30);
		leftButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		leftButton.setGraphic(new ImageView(Images.leftArrow));
		leftButton.setOnAction(e->{
			currentLabel--;
			if(currentLabel < 0)currentLabel += Labels.size();
			this.switchLabel();
		});
		
		rightButton = new Button();
		rightButton.setPrefSize(30, 30);
		rightButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		rightButton.setGraphic(new ImageView(Images.rightArrow));
		rightButton.setOnAction(e->{
			currentLabel++;
			currentLabel %= Labels.size();
			this.switchLabel();
		});
	}
	public Label createLabel(String label) {
		Label t;
		t = new Label(label);
		t.setFont(Fonts.settingFont);
		t.setMinWidth(390);
		t.setAlignment(Pos.CENTER);
		return t;
	}
	public void switchLabel() {
		this.getChildren().clear();
		this.getChildren().addAll(leftButton, Labels.get(currentLabel), rightButton);
	}
	public String getCurrentLabelText() {
		return Labels.get(currentLabel).getText();
	}
	
}
