package com.kennie.android.base.common;

import android.app.Application;

/**
 * @author Kennie
 * @desc 描述
 */
public abstract class KennieBaseApp<BaseProjectApp extends KennieBaseApp> extends Application {

    public BaseProjectApp baseProjectApp;
    private static Application instance;

    public static <App extends KennieBaseApp> App getInstance(Class<App> appClass) {
        return (App) instance;
    }

    public abstract void init();

    @Override
    public void onCreate() {
        super.onCreate();
        baseProjectApp = (BaseProjectApp) this;
        instance = baseProjectApp;
    }

    /**
     * 此方法用于主动设置实例化 application 对象以实现一些需要 context 的场合下不需要传参，减少工作量，
     * 在您有实现 App extends BaseApp 的情况下无需调用，
     * 请勿手动调用此方法，此接口仅用于 BaseActivity 以固定逻辑调用。
     *
     * @param context Application 上下文
     * @hide
     */
    public static void setPrivateInstance(Application context) {
        KennieBaseApp.instance = context;
    }

    /**
     * 此方法用于主动获取实例化的 application 对象以实现一些需要 context 的场合下不需要传参，减少工作量，
     * 如需要使用 App 的实例化对象，请勿使用本方法，
     * 请自行实现 getInstance() 方法，或使用 {@link #getInstance(Class)} 来获取。
     *
     * @return 例化的 application 对象
     */
    public static Application getPrivateInstance() {
        if (instance == null) {
            return null;
        }
        return instance;
    }
}
