package com.poc.consumer.validateContract



import com.poc.consumer.dto.OrderDTO
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.reactive.function.client.WebClient


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = arrayOf("com.poc:producer:+:stubs:9090"), stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ConsumerTest {

    @Test
    fun validateApprovedContract(){
        val order = WebClient.create("http://localhost:9090/order/1").get()
                .retrieve()
                .bodyToMono(OrderDTO::class.java)
                .block()
        Assert.assertTrue(order!!.status)

    }

    @Test
    fun notApprovedContract(){
        val order = WebClient.create("http://localhost:9090/order/13").get()
                .retrieve()
                .bodyToMono(OrderDTO::class.java)
                .block()
        Assert.assertFalse(order!!.status)

    }
}