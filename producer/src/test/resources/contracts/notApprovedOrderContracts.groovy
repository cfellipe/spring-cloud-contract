
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return true when called")
    request {
        method 'GET'
        url '/order/13'
    }
    response {
        status 200
        body("""{"status":false}""")
        headers {
            contentType('application/json')
        }
    }
}
