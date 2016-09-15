package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

public interface ISelectable {
	void setSelected(boolean select);
	boolean isSelected();
	boolean contains(Point p, Point pCmpRelPrnt);
	void draw(Graphics g, Point pt);

}
