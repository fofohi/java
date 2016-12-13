package websocket;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by alongsea2 on 16/12/8.
 */
public class WriteReadThread implements Runnable {

    private Dto dto;

    public WriteReadThread(Dto dto) {
        this.dto = dto;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = dto.getSocket().getInputStream();
            int n = 0;
            while ((n = inputStream.read()) != -1){
                System.out.println((char) n);
            }

        } catch (IOException e) {
            dto.setSocket(null);
            try {
                Thread.currentThread().interrupt();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
