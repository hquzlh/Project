package observer;

public interface Watched {
    public  void addWatcher(Watcher watcher);
    public  void deleteWatcher(Watcher watcher);
    public  void notifyWatchers();
}
