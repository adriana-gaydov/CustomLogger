package logger.factories;

import logger.layout.Layout;
import logger.layout.SimpleLayout;
import logger.layout.XmlLayout;

public class LayoutFactory {

    public static Layout buildLayout(String type) {
        switch (type) {
            case "SimpleLayout":
                return new SimpleLayout();
            case "XmlLayout":
                return new XmlLayout();
            default:
                throw new IllegalArgumentException("No such layout!");
        }
    }
}
