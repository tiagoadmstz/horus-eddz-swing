package com.cooperstandard.dal.config;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;


public class ControleInstancias {

    private static final Map<String, Object> map = new HashMap();

    public static Object getInstance(Class<?> clazz) {
        Object ob = map.get(clazz.getName());
        if (ob == null) {
            try {
                ob = createObject(clazz);
                addInstance(clazz.getName(), ob);
                return ob;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return ob;
    }

    public static boolean isInstaced(Class<?> clazz){
        return map.containsKey(clazz.getName());
    }
    
    public static void addInstance(final String name, Object object) {
        JFrame frame = (JFrame) object;
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                removeInstance(name);
            }
        });
        map.put(name, object);
    }

    private static void removeInstance(String name) {
        map.remove(name);
    }

    private static Object createObject(Class<?> obj) {
        try {
            for (Constructor ctt : obj.getConstructors()) {
                if (ctt.getParameters() != null && ctt.getParameterCount() == 0) {
                    return ctt.newInstance();
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}
