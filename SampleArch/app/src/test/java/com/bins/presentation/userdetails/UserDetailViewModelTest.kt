package com.bins.presentation.userdetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bins.presentation.entity.User
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UserDetailViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    lateinit var userDetailViewModel: UserDetailViewModel


    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        userDetailViewModel = UserDetailViewModel()

    }


    @Test
    fun getUserTest() = runBlocking {

        // Attacch fake observer
        val observer =
            Mockito.mock(androidx.lifecycle.Observer::class.java) as androidx.lifecycle.Observer<User>
        userDetailViewModel.selectedUser.observeForever(observer)
        // Invoke
        userDetailViewModel.getUser(
            User(
                0, "Binil", "Thomas", "jkdjlks",
                "jkdjlk", "Male", "Calicut", "8113873716",
                "binil@gmail.com", "24/01/1984"
            )
        )
        // Verify
        assertNotNull(userDetailViewModel.selectedUser.value)
        assertEquals("Binil",userDetailViewModel.selectedUser.value?.fname)

    }

}
