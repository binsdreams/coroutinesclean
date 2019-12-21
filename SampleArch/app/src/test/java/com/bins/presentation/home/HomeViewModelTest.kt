package com.bins.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bins.domain.entity.DataEntity
import com.bins.domain.entity.UserResponseEntity
import com.bins.domain.usecases.UserInfoUseCase
import com.bins.presentation.base.Mapper
import com.bins.presentation.entity.Data
import com.bins.presentation.entity.UserResponse
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

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class HomeViewModelTest {

    @Mock
    lateinit var getUserInfoUseCase: UserInfoUseCase

    @Mock
    lateinit var mapper: Mapper<DataEntity<UserResponseEntity>, Data<UserResponse>>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    lateinit var mainViewModel: HomeViewModel


    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        mainViewModel = HomeViewModel(getUserInfoUseCase,mapper)

    }


    @Test
    fun fetchUsersTest() = runBlocking{

        Mockito.`when`(getUserInfoUseCase.getUserData(emptyMap())).thenAnswer{
            return@thenAnswer Maybe.just(ArgumentMatchers.any<ReceiveChannel<DataEntity<UserResponseEntity>>>())
        }

        // Attacch fake observer
        val observer = Mockito.mock(androidx.lifecycle.Observer::class.java) as androidx.lifecycle.Observer<Data<UserResponse>>
        mainViewModel.getUserLiveData().observeForever(observer)
        // Invoke
        mainViewModel.fetchUsers()
        // Verify
        assertNotNull(mainViewModel.users)


    }
}
