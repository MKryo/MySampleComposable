package com.example.sampleapp

import com.example.sampleapp.data.BookmarkRepository
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class BookmarkRepositoryTest {
    private lateinit var fakePreferences : FakeBookmarkPreferences
    private lateinit var repository : BookmarkRepository

    @Before
    fun setup() {
        fakePreferences = FakeBookmarkPreferences()
        repository = BookmarkRepository(fakePreferences)
    }

    @Test
    fun initialBookmarkState_shouldBeFalse() = runTest {
            val result = repository.getBookmarkState().first()
            assertFalse(result)
    }

    @Test
    fun `trueを保存したらtrueを取得できるよ`() = runTest {
            repository.setBookmarkState(true)
            val result = repository.getBookmarkState().first()
            assertTrue(result)
        }

    @Test
    fun `falseを保存したらfalseを取得できるよ`(): Unit = runTest {
            repository.setBookmarkState(false)
            val result = repository.getBookmarkState().first()
            assertFalse(result)
    }
}