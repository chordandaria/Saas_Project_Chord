package aria.p.chord.myutilslibrary;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class ShareHelper {
    private Context mContext;
    public static final String FILE_NAME = "my_info";

    public ShareHelper() {
    }

    public ShareHelper(Context mContext) {
        this.mContext = mContext;
    }
    public String getAuth()
    {
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        return sp.getString("auth","");
    }
    public String getCMS()
    {
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        return sp.getString("cms","");
    }
    public String getStore()
    {
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        return sp.getString("store","");
    }
    public void setAuth(String auth)
    {
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("auth",auth);
        editor.commit();
    }
    public void setCompanyId(int companyId){
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt("company",companyId);
        editor.commit();

    }
    public int getSome()
    {
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        return sp.getInt("eve",-1);
    }

    public int getCompanyId()
    {
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        return sp.getInt("company",-1);
    }

    public String getHuanjin()
    {
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        return sp.getString("huanjin","");
    }

    public void setHuanjin(String huanjin)
    {
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("huanjin",huanjin);
        editor.commit();
    }
    public void loginOut()
    {
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.remove("auth");
        editor.remove("company");
        editor.commit();
    }
    public static void put(Context context, String key, Object obj) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (obj instanceof Boolean) {
            editor.putBoolean(key, (Boolean) obj);
        } else if (obj instanceof Float) {
            editor.putFloat(key, (Float) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(key, (Integer) obj);
        } else if (obj instanceof Long) {
            editor.putLong(key, (Long) obj);
        } else {
            editor.putString(key, (String) obj);
        }
        editor.commit();
    }
    public static Object get(Context context, String key, Object defaultObj) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
        if (defaultObj instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObj);
        } else if (defaultObj instanceof Float) {
            return sp.getFloat(key, (Float) defaultObj);
        } else if (defaultObj instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObj);
        } else if (defaultObj instanceof Long) {
            return sp.getLong(key, (Long) defaultObj);
        } else if (defaultObj instanceof String) {
            return sp.getString(key, (String) defaultObj);
        }
        return null;
    }

    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
        return sp.contains(key);
    }
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
        Map<String, ?> map = sp.getAll();
        return map;
    }
    public boolean checkLogined()
    {
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        String auth=sp.getString("auth","");
        if (auth.equals(""))
        {
            return false;
        }else {
            return true;
        }
    }
}
