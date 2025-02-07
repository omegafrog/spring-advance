package hello.advance.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static java.lang.Thread.sleep;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalArgumentException("예외");
        }
        sleep(1000);
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
