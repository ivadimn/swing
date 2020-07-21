package ui;

import ui.FormEvent;

import java.util.EventListener;

public interface FormListener  extends EventListener {
    public void formEventOccurred(FormEvent ev);
}
