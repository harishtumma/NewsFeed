import com.example.newsfeed.domain.data.ErrorData


sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val error: ErrorData) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}