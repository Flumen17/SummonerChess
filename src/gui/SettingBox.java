package gui;

import java.util.ArrayList;
import java.util.List;

import constant.Fonts;
import constant.Images;
import constant.Numbers;
import constant.Sounds;
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
		this.setMinWidth(Numbers.SETTINGBOX_WIDTH);
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
		leftButton.setPrefSize(Numbers.ARROW_SIZE, Numbers.ARROW_SIZE);
		leftButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		leftButton.setGraphic(new ImageView(Images.leftArrow));
		leftButton.setOnAction(e->{
			Sounds.click2.play();
			currentLabel--;
			if(currentLabel < 0) {
				currentLabel += Labels.size();
			}
			this.switchLabel();
		});
		rightButton = new Button();
		rightButton.setPrefSize(Numbers.ARROW_SIZE, Numbers.ARROW_SIZE);
		rightButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		rightButton.setGraphic(new ImageView(Images.rightArrow));
		rightButton.setOnAction(e->{
			Sounds.click2.play();
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
