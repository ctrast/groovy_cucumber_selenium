package context

class ContextUtil {

    public static final ThreadLocal<Context> threadLocal = new ThreadLocal<Context>()

    static void set(Context context) {
        threadLocal.set(context)
    }

    static void unset() {
        threadLocal.remove()
    }

    static Context get() {
        return threadLocal.get()
    }

}