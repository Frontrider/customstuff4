package cubex2.cs4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import cubex2.cs4.api.Content;
import cubex2.cs4.api.ContentRegistry;
import cubex2.cs4.api.LoaderPredicate;
import cubex2.cs4.plugins.vanilla.VanillaPlugin;

import java.lang.reflect.Type;

public class TestUtil
{
    public static GsonBuilder createGsonBuilder()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();

        new VanillaPlugin().registerContent(new ContentRegistry()
        {
            @Override
            public <T extends Content> void registerContentType(String typeName, Class<T> clazz)
            {
                // No OP
            }

            @Override
            public <T> void registerDeserializer(Type type, JsonDeserializer<T> deserializer)
            {
                gsonBuilder.registerTypeAdapter(type, deserializer);
            }

            @Override
            public void registerLoaderPredicate(String name, LoaderPredicate predicate)
            {
                // No OP
            }
        });

        return gsonBuilder;
    }
}