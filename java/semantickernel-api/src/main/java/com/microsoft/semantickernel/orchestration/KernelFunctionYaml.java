package com.microsoft.semantickernel.orchestration;

import com.microsoft.semantickernel.builders.BuildersSingleton;
import com.microsoft.semantickernel.semanticfunctions.PromptTemplateFactory;
import java.io.IOException;
import java.nio.file.Path;
import javax.annotation.Nullable;

public class KernelFunctionYaml {

    /// <summary>
    /// Creates a <see cref="KernelFunction"/> instance for a prompt function using the specified markdown text.
    /// </summary>
    /// <param name="text">YAML representation of the <see cref="PromptTemplateConfig"/> to use to create the prompt function</param>
    /// <param name="promptTemplateFactory">>Prompt template factory.</param>
    /// <param name="loggerFactory">The <see cref="ILoggerFactory"/> to use for logging. If null, no logging will be performed.</param>
    /// <returns>The created <see cref="KernelFunction"/>.</returns>
    public static KernelFunction fromPromptYaml(
        String text,
        @Nullable PromptTemplateFactory promptTemplateFactory
    ) throws IOException {
        return BuildersSingleton.INST.getInstance(Builder.class)
            .fromPromptYaml(text, promptTemplateFactory);
    }

    public static KernelFunction fromPromptYaml(String text) throws IOException {
        return fromPromptYaml(text, null);
    }

    public static KernelFunction fromYaml(Path filePath) throws IOException {
        return fromYaml(filePath.toAbsolutePath().toString());
    }

    public static KernelFunction fromYaml(String filePath) throws IOException {
        return BuildersSingleton.INST.getInstance(Builder.class).fromYaml(filePath);
    }

    public interface Builder {

        KernelFunction fromPromptYaml(
            String text,
            @Nullable PromptTemplateFactory promptTemplateFactory
        ) throws IOException;

        KernelFunction fromYaml(String filePath) throws IOException;
    }


}
