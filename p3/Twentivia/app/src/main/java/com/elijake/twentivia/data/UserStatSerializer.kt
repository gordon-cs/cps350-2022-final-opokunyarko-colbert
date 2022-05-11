import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.elijake.twentivia.UserStat
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object UserStatSerializer : Serializer<UserStat> {
    override val defaultValue: UserStat = UserStat.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserStat {
        try {
            return UserStat.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: UserStat,
        output: OutputStream) = t.writeTo(output)
}