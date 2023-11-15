package org.example;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public class Main
{
    public static void main( String[] args )
        throws Exception
    {
        Source compiledScript = Source.newBuilder( "python", SCRIPT, "test" ).build();
        Context context = createContext();
        Value v = context.eval( compiledScript );
        System.out.println( v );
    }

    private static Context createContext()
    {
        HostAccess accessToPublic = HostAccess.newBuilder()
            .allowPublicAccess( true )
            .build();
        return Context.newBuilder( "python" )
            .allowHostAccess( accessToPublic )
            .build();
    }

    private static final String SCRIPT =
        "'doesn't matter'\n";
}