package by.eapp.gosport.di

import by.eapp.gosport.data.const.Const
import by.eapp.gosport.data.remote.ApiService
import by.eapp.gosport.data.repository.MenuRepositoryImpl
import by.eapp.gosport.domain.repository.MenuRepository
import by.eapp.gosport.domain.use_cases.GetCategoriesUseCase
import by.eapp.gosport.domain.use_cases.GetMenuUseCase
import by.eapp.gosport.domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient):
            Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Const.BASE_URL)
        .client(okHttpClient)
        .build()


    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()


    @Singleton
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun providesMenuRepository(apiService: ApiService): MenuRepository {
        return MenuRepositoryImpl(apiService = apiService)
    }


    @Provides
    @Singleton
    fun providesUseCases(
        getMenuUseCase: GetMenuUseCase,
        getCategoriesUseCase: GetCategoriesUseCase
    ): UseCases {
        return UseCases(getMenuUseCase, getCategoriesUseCase)
    }
    @Provides
    @Singleton
    fun providesAppService(retrofit: Retrofit) =
        retrofit.create(ApiService::class.java)
}