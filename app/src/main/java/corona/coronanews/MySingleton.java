package corona.coronanews;

/**
 * Created by shubham on 25/10/17.
 */

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by shubham on 28/9/17.
 */

public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue requestQueue;
    private Context mctx;

    public MySingleton(Context mctx) {
        this.mctx = mctx;
        requestQueue=getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }

    public static  synchronized MySingleton getmInstance(Context ctx){

        if(mInstance==null){
            mInstance=new MySingleton(ctx);
        }
        return mInstance;
    }
    public<T> void addToReqQue(Request<T> request){
        requestQueue.add(request);
    }
}

