package org.hedhman.niclas;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.junit.jupiter.api.Test;

public class GraalTest
{
    @Test
    void testPython()
        throws Exception
    {
        Source compiledScript = Source.newBuilder( "python", SCRIPT, "test" ).build();
        Context context = createContext();
        Value v = context.eval( compiledScript );
        System.out.println( v );
    }

    Context createContext()
    {
        HostAccess accessToPublic = HostAccess.newBuilder()
            .allowPublicAccess( true )
            .build();
        return Context.newBuilder( "python" )
            .allowHostAccess( accessToPublic )
            .build();
    }

    final String SCRIPT = "'doesn't matter'\n";
}