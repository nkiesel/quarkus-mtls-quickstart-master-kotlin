package org.acme.client.mtls

import io.quarkus.test.junit.NativeImageTest

@NativeImageTest
class NativeGreetingResourceIT : GreetingResourceTest() { // Execute the same tests but in native mode.
}
