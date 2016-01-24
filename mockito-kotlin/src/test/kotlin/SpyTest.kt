/*
 * The MIT License
 *
 * Copyright (c) 2016 Niek Haarman
 * Copyright (c) 2007 Mockito contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.nhaarman.expect.expect
import com.nhaarman.mockito_kotlin.spy
import org.junit.Test
import org.mockito.exceptions.base.MockitoException

class SpyTest {

    private val interfaceInstance: MyInterface = MyClass()
    private val openClassInstance: MyClass = MyClass()
    private val closedClassInstance: ClosedClass = ClosedClass()

    @Test
    fun spyInterfaceInstance() {
        /* When */
        val result = spy(interfaceInstance)

        /* Then */
        expect(result).toNotBeNull()
    }

    @Test
    fun spyOpenClassInstance() {
        /* When */
        val result = spy(openClassInstance)

        /* Then */
        expect(result).toNotBeNull()
    }

    @Test(expected = MockitoException::class)
    fun spyClosedClassInstance() {
        /* When */
        spy(closedClassInstance)
    }

    private interface MyInterface
    private open class MyClass : MyInterface
    private class ClosedClass
}

