package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 09:34
 **/

public class Transporter implements Watched {
    private List<Watcher> list=new ArrayList<Watcher>();
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    public void deleteWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    public void notifyWatchers() {
        for (Watcher w :list) {
            w.update();
        }
    }
}
