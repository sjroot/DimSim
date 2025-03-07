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


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventPreview;
import com.google.gwt.user.client.ui.impl.PopupImpl;

/**
 * A panel that can "pop up" over other widgets. It overlays the browser's
 * client area (and any previously-created popups).
 * 
 * <p>
 * <img class='gallery' src='PopupPanel.png'/>
 * </p>
 * 
 * <p>
 * <h3>Example</h3>
 * {@example com.google.gwt.examples.PopupPanelExample}
 * </p>
 */
public class ModalPopupPanel extends PopupPanel implements SourcesPopupEvents,
    EventPreview {

//j  private static PopupImpl impl = (PopupImpl) GWT.create(PopupImpl.class);

//j  private PopupListenerCollection popupListeners;
//j  private boolean showing, autoHide;

  /**
   * Creates an empty popup panel. A child widget must be added to it before it
   * is shown.
   */
  public ModalPopupPanel() {
    super(/*impl.createElement()*/);
//j    DOM.setStyleAttribute(getElement(), "position", "absolute");
  }

  /**
   * Creates an empty popup panel, specifying its "auto-hide" property.
   * 
   * @param autoHide <code>true</code> if the popup should be automatically
   *          hidden when the user clicks outside of it
   */
  public ModalPopupPanel(boolean autoHide) {
	  super(autoHide);
//j    this();
//j    this.autoHide = autoHide;
  }

//j  public void addPopupListener(PopupListener listener) {
//j    if (popupListeners == null)
//j      popupListeners = new PopupListenerCollection();
//j    popupListeners.add(listener);
//j  }

  /**
   * Gets the popup's left position relative to the browser's client area.
   * 
   * @return the popup's left position
   */
//j  public int getPopupLeft() {
//j    return DOM.getIntAttribute(getElement(), "offsetLeft");
//j  }

  /**
   * Gets the popup's top position relative to the browser's client area.
   * 
   * @return the popup's top position
   */
//j  public int getPopupTop() {
//j    return DOM.getIntAttribute(getElement(), "offsetTop");
//j  }

  /**
   * Hides the popup. This has no effect if it is not currently visible.
   */
//j  public void hide() {
//j    hide(false);
//j  }

  public boolean onEventPreview(Event event) {
    int type = DOM.eventGetType(event);
    switch (type) {
      case Event.ONKEYDOWN: {
        return onKeyDownPreview((char) DOM.eventGetKeyCode(event),
          KeyboardListenerCollection.getKeyboardModifiers(event));
      }
      case Event.ONKEYUP: {
        return onKeyUpPreview((char) DOM.eventGetKeyCode(event),
          KeyboardListenerCollection.getKeyboardModifiers(event));
      }
      case Event.ONKEYPRESS: {
        return onKeyPressPreview((char) DOM.eventGetKeyCode(event),
          KeyboardListenerCollection.getKeyboardModifiers(event));
      }

      case Event.ONFOCUS:
      case Event.ONBLUR:
      case Event.ONMOUSEOVER:
      case Event.ONMOUSEDOWN:
      case Event.ONMOUSEUP:
      case Event.ONMOUSEMOVE:
      case Event.ONMOUSEOUT:
      case Event.ONCLICK:
      case Event.ONDBLCLICK: {
        // Don't eat events if event capture is enabled, as this can interfere
        // with dialog dragging, for example.
        if (DOM.getCaptureElement() == null) {
          // Disallow mouse events outside of the popup.
          Element target = DOM.eventGetTarget(event);
          if (!DOM.isOrHasChild(getElement(), target)) {
            // If it's a click event, and auto-hide is enabled: hide the popup
            // and _don't_ eat the event.
//            if (autoHide && (type == Event.ONCLICK)) {
//              hide(true);
//              return true;
//            }
            return false;
          }
        }
        break;
      }
    }
//    Window.alert("onEventPreview: event-"+event+"_"+type); 
    return true;
  }

  /**
   * Popups get an opportunity to preview keyboard events before they are passed
   * to any other widget.
   * 
   * @param key the key code of the depressed key
   * @param modifiers keyboard modifiers, as specified in
   *          {@link KeyboardListener}.
   * @return <code>false</code> to suppress the event
   */
  public boolean onKeyDownPreview(char key, int modifiers) {
    return true;
  }

  /**
   * Popups get an opportunity to preview keyboard events before they are passed
   * to any other widget.
   * 
   * @param key the unicode character pressed
   * @param modifiers keyboard modifiers, as specified in
   *          {@link KeyboardListener}.
   * @return <code>false</code> to suppress the event
   */
  public boolean onKeyPressPreview(char key, int modifiers) {
    return true;
  }

  /**
   * Popups get an opportunity to preview keyboard events before they are passed
   * to any other widget.
   * 
   * @param key the key code of the released key
   * @param modifiers keyboard modifiers, as specified in
   *          {@link KeyboardListener}.
   * @return <code>false</code> to suppress the event
   */
/*j
  public boolean onKeyUpPreview(char key, int modifiers) {
    return true;
  }

  public boolean remove(Widget w) {
    if (!super.remove(w))
      return false;
    return true;
  }
*/
//j  public void removePopupListener(PopupListener listener) {
//j    if (popupListeners != null)
//j      popupListeners.remove(listener);
//j  }

  /**
   * Sets the popup's position relative to the browser's client area. The
   * popup's position may be set before calling {@link #show()}.
   * 
   * @param left the left position, in pixels
   * @param top the top position, in pixels
   */
/*j
  public void setPopupPosition(int left, int top) {
    // Keep the popup within the browser's client area, so that they can't get
    // 'lost' and become impossible to interact with. Note that we don't attempt
    // to keep popups pegged to the bottom and right edges, as they will then
    // cause scrollbars to appear, so the user can't lose them.
    if (left < 0)
      left = 0;
    if (top < 0)
      top = 0;

    // Set the popup's position manually, allowing setPopupPosition() to be
    // called before show() is called (so a popup can be positioned without it
    // 'jumping' on the screen).
    Element elem = getElement();
    DOM.setStyleAttribute(elem, "left", left + "px");
    DOM.setStyleAttribute(elem, "top", top + "px");
  }
*/
  /**
   * Shows the popup. It must have a child widget before this method is called.
   */
//j  public void show() {
//j    if (showing)
//j      return;
//j    showing = true;
//j    DOM.addEventPreview(this);
//j
//j    RootPanel.get().add(this);
//j    impl.onShow(getElement());
//j  }

//j  private void hide(boolean autoClosed) {
//j    if (!showing)
//j      return;
//j    showing = false;
//j    DOM.removeEventPreview(this);
//j
//j    RootPanel.get().remove(this);
//j    impl.onHide(getElement());
//j    if (popupListeners != null)
//j      popupListeners.firePopupClosed(this, autoClosed);
//j  }
}
