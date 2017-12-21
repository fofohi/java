package groovy

import com.szh.im.service.GroovyService
import com.szh.im.service.TestOneService
import org.springframework.beans.factory.annotation.Autowired

class GroovyServiceImpl implements GroovyService{

    @Autowired
    TestOneService testOneService

    @Override
    void test() {
        testOneService.update()
        println 1
    }
}