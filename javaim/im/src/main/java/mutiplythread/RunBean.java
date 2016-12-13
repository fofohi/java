package mutiplythread;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by alongsea2 on 16/12/1.
 */
public class RunBean {

    public static void main(String[] args) {

        new Thread(new CommandReadLine()).start();
        for(int i = 45; i > 0 ; i--){
            new Thread(new ThreadBean()).start();
        }

        NotifyBean no = new NotifyBean();
        new Thread(no).start();
        new Thread(new WatiBean(no)).start();
    }

    private static class CommandReadLine implements Runnable{


        @Override
        public void run() {

            InputStream inConsole = System.in;
            int n = 0;
            try {
                while ((n = inConsole.read()) != -1){
                    String s = (char) n + "";
                    if (s.equals("E")){
                        StaticBean.setFlag(false);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }

}
