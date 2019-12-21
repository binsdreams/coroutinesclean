package com.bins.domain.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bins.domain.entity.DataEntity
import com.bins.domain.entity.UserResponseEntity
import com.bins.domain.repo.UserRepo
import io.reactivex.Maybe
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import kotlin.coroutines.CoroutineContext

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UserInfoUseCaseTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var  coroutineContext: CoroutineContext

    @Mock
    lateinit var  repositories: UserRepo

    lateinit var userInfoUseCase: UserInfoUseCase


    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        userInfoUseCase = UserInfoUseCase(coroutineContext,repositories)
    }


    @Test
    fun getUserDataTest() = runBlocking {

        Mockito.`when`(repositories.getUsers()).thenAnswer{
            return@thenAnswer Maybe.just(ArgumentMatchers.any<DataEntity<UserResponseEntity>>())
        }
       var responseEntity =  userInfoUseCase.getUserData(emptyMap())
        // Verify
        assertNotNull(responseEntity)
    }

}
