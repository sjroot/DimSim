/*
 * Copyright 2006 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.user.client.ui;

import com.google.gwt.user.client.DOM;

/**
 * A form of popup that has a caption area at the top and can be dragged by the
 * user.
 * 
 * <p>
 * <img class='gallery' src='DialogBox.png'/>
 * </p>
 * 
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.gwt-DialogBox { the outside of the dialog }</li>
 * <li>.gwt-DialogBox .Caption { the caption }</li>
 * </ul>
 * 
 * <p>
 * <h3>Example</h3> {@example com.google.gwt.examples.DialogBoxExample}
 * </p>
 */
public class DialogBox extends ModalPopupPanel implements HasHTML, MouseListener {

  private HTML caption = new HTML();
  private Widget child;
  private boolean dragging;
  private int dragStartX, dragStartY;
  private DockPanel panel = new DockPanel();

  /**
   * Creates an empty dialog box. It should not be shown until its child widget
   * has been added using {@link #add}.
   */
  public DialogBox() {
    panel.add(caption, DockPanel.NORTH);
    panel.setCellWidth(caption, "100%");
    super.setWidget(panel);

    setStyleName("gwt-DialogBox");
    caption.setStyleName("Caption");
    caption.addMouseListener(this);
  }

  public String getHTML() {
    return caption.getHTML();
  }

  public String getText() {
    return caption.getText();
  }

  public void onMouseDown(Widget sender, int x, int y) {
    dragging = true;
    DOM.setCapture(caption.getElement());
    dragStartX = x;
    dragStartY = y;
  }

  public void onMouseEnter(Widget sender) {
  }

  public void onMouseLeave(Widget sender) {
  }

  public void onMouseMove(Widget sender, int x, int y) {
    if (dragging) {
      int absX = x + getAbsoluteLeft();
      int absY = y + getAbsoluteTop();
      setPopupPosition(absX - dragStartX, absY - dragStartY);
    }
  }

  public void onMouseUp(Widget sender, int x, int y) {
    dragging = false;
    DOM.releaseCapture(caption.getElement());
  }

  public boolean remove(Widget w) {
    if (child != w) {
      return false;
    }

    panel.remove(w);
    return true;
  }

  public void setHTML(String html) {
    caption.setHTML(html);
  }

  public void setText(String text) {
    caption.setText(text);
  }

  public void setWidget(Widget w) {
    // If there is already a widget, remove it.
    if (child != null) {
      panel.remove(child);
    }

    // Add the widget to the center of the dock panel.
    if (w != null) {
      panel.add(w, DockPanel.CENTER);
      panel.setCellWidth(w,"100%");
      panel.setCellHeight(w,"100%");
    }

    child = w;
  }
}
