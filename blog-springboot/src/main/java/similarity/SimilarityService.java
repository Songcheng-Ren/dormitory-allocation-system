// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: similarity.proto

package similarity;

public final class SimilarityService {
  private SimilarityService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_similarity_similarityRequest_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_similarity_similarityRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_similarity_similarityResponse_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_similarity_similarityResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\020similarity.proto\022\nsimilarity\"U\n\021simila" +
      "rityRequest\022\020\n\010choices1\030\001 \003(\005\022\r\n\005text1\030\002" +
      " \001(\t\022\020\n\010choices2\030\003 \003(\005\022\r\n\005text2\030\004 \001(\t\"#\n" +
      "\022similarityResponse\022\r\n\005score\030\001 \001(\0012^\n\nSi" +
      "milarity\022P\n\rgetSimilarity\022\035.similarity.s" +
      "imilarityRequest\032\036.similarity.similarity" +
      "Response\"\000B\025B\021SimilarityServiceP\001b\006proto" +
      "3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_similarity_similarityRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_similarity_similarityRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_similarity_similarityRequest_descriptor,
        new String[] { "Choices1", "Text1", "Choices2", "Text2", });
    internal_static_similarity_similarityResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_similarity_similarityResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_similarity_similarityResponse_descriptor,
        new String[] { "Score", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}